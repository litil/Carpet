<?php
// src/Acme/DemoBundle/Admin/PostAdmin.php

namespace Carpet\Bundle\AdminBundle\Admin;

use Sonata\AdminBundle\Admin\Admin;
use Sonata\AdminBundle\Datagrid\ListMapper;
use Sonata\AdminBundle\Datagrid\DatagridMapper;
use Sonata\AdminBundle\Form\FormMapper;

class PetAdmin extends Admin
{
    // Fields to be shown on create/edit forms
    protected function configureFormFields(FormMapper $formMapper)
    {
        $formMapper
            ->with('Infos')
                ->add('name', 'text', array('label' => 'Nom'))
                ->add('points', 'integer', array('label' => 'Points'))
                ->add('mood', 'integer', array('label' => 'Humeur'))
            ->with('Gadgets')
                ->add('possessions', 'sonata_type_collection', array(), array(
                    'edit' => 'inline',
                    'inline' => 'table',
                    'sortable'  => 'position',
                    'placeholder' => 'Pas de gadgets pour l\'instant'
            ))
            ->with('Évènements')
                ->add('events', 'sonata_type_collection', array(), array(
                    'inline' => 'table',
                    'sortable'  => 'position',
                    'placeholder' => 'Pas d\'évènements pour l\'instant'
            ))
                
        ;
    }

    // Fields to be shown on filter forms
    protected function configureDatagridFilters(DatagridMapper $datagridMapper)
    {
        $datagridMapper
            ->add('name')
            ->add('points')
            ->add('mood')
        ;
    }

    // Fields to be shown on lists
    protected function configureListFields(ListMapper $listMapper)
    {
        $listMapper
            ->addIdentifier('name')
            ->add('points')
            ->add('mood')
        ;
    }
}